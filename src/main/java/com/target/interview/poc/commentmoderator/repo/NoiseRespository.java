package com.target.interview.poc.commentmoderator.repo;

import com.target.interview.poc.commentmoderator.constants.AppConstants;
import com.target.interview.poc.commentmoderator.constants.DataBaseConstats;
import com.target.interview.poc.commentmoderator.constants.DataBaseQueryConstants;
import com.target.interview.poc.commentmoderator.data.CommentValidationResponse;
import com.target.interview.poc.commentmoderator.data.dboperations.NoiseBlackListResponse;
import com.target.interview.poc.commentmoderator.mapper.BlackListMapper;
import com.target.interview.poc.commentmoderator.mapper.NoiseDaoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.*;

import static java.util.stream.Collectors.toList;

@Repository
public class NoiseRespository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private BlackListMapper blackListMapper;

    public CommentValidationResponse findMatchingNoise(String comment)
    {
        String[] split = comment.split(" ");
        List<String> allWords = Arrays.asList(split);

        CommentValidationResponse response = new CommentValidationResponse();

        String sql = DataBaseQueryConstants.FIND_NOISE;
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue(DataBaseConstats.NOISE_NAME, allWords);

        List<NoiseDaoTO> responseNoise = jdbcTemplate.query(sql, paramMap, blackListMapper);

        List<String> matchingSevere = new ArrayList<>();
        List<String> matchingModerate = new ArrayList<>();

        filterNoise(response, responseNoise, matchingSevere, matchingModerate);

        response.setModerate(matchingModerate);
        response.setSevere(matchingSevere);

        return response;
    }

    private void filterNoise(CommentValidationResponse response,
            List<NoiseDaoTO> responseNoise, List<String> matchingSevere, List<String> matchingModerate) {

        for (NoiseDaoTO noiseDao:responseNoise) {

            response.setValid(true);

            if(AppConstants.SEVERE.equalsIgnoreCase(noiseDao.getType()))
                matchingSevere.add(noiseDao.getName());
            else
                matchingModerate.add(noiseDao.getName());
        }
    }

    public List<NoiseBlackListResponse> addBlackList(String type, List<String> list)
    {
        List<NoiseBlackListResponse> response =null;

        if("severe".equalsIgnoreCase(type))
            response = addToBlackList(type, list);
        else
            response = addToBlackList(type, list);

        return response;
    }

    private List<NoiseBlackListResponse> addToBlackList(String type, List<String> list) {

        List<NoiseBlackListResponse> response = new ArrayList<>(list.size());

        for(String noise:list)
        {
            NoiseBlackListResponse noiseOperationResponse =  new NoiseBlackListResponse();
            noiseOperationResponse.setNoise(noise);
            noiseOperationResponse.setType(type);
            noiseOperationResponse.setNoiseId(UUID.randomUUID());

            String sql = DataBaseQueryConstants.INSERT_NOISE;
            MapSqlParameterSource paramMap = new MapSqlParameterSource();
            paramMap.addValue(DataBaseConstats.NOISE_NAME, noise);
            paramMap.addValue(DataBaseConstats.ID, noiseOperationResponse.getNoiseId());
            paramMap.addValue(DataBaseConstats.NOISE_TYPE, type);

            try
            {
                jdbcTemplate.update(sql,paramMap);
            }
            catch (Exception e)
            {
                noiseOperationResponse.setError("Already exists!");
            }

            response.add(noiseOperationResponse);
        }

        return response;
    }


    public List<NoiseBlackListResponse> deleteNoise(String type, List<String> list)
    {
        List<NoiseBlackListResponse> response = new ArrayList<>(list.size());

        for(String noise:list)
        {
            NoiseBlackListResponse noiseOperationResponse =  new NoiseBlackListResponse();
            noiseOperationResponse.setNoise(noise);
            noiseOperationResponse.setType(type);

            String sql = DataBaseQueryConstants.DELETE_NOISE;
            MapSqlParameterSource paramMap = new MapSqlParameterSource();
            paramMap.addValue(DataBaseConstats.NOISE_NAME, noise);

            try
            {
                jdbcTemplate.update(sql,paramMap);
            }
            catch (Exception e)
            {
                noiseOperationResponse.setError("Already exists!");
            }

            response.add(noiseOperationResponse);
        }

        return response;
    }

    private List<String>  locateNoise(List<String> allWords, ArrayList<String> listOfNoise) {

        return  allWords
                .parallelStream()
                .filter(listOfNoise::contains)
                .collect(toList());
    }
}
