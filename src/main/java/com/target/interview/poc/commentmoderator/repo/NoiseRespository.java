package com.target.interview.poc.commentmoderator.repo;

import com.target.interview.poc.commentmoderator.data.CommentValidationResponse;
import com.target.interview.poc.commentmoderator.data.dboperations.NoiseBlackListResponse;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Repository
public class NoiseRespository {

    Set<String> severeNoise = new HashSet<>();

    {
        severeNoise.add("ugly");
    }

    Set<String> moderateNoise = new HashSet<>();

    {
        moderateNoise.add("bad");
    }


    public CommentValidationResponse findMatchingNoise(String comment)
    {
        String[] split = comment.split(" ");
        List<String> allWords = Arrays.asList(split);
        CommentValidationResponse response = new CommentValidationResponse();

        List<String> matchingSevere = locateNoise(allWords, new ArrayList<>(severeNoise));
        List<String> matchingModerate = locateNoise(allWords, new ArrayList<>(moderateNoise));

        if(!CollectionUtils.isEmpty(matchingSevere)||!CollectionUtils.isEmpty(matchingModerate)) {
            response.setValid(true);
        }

        response.setModerate(matchingModerate);
        response.setSevere(matchingSevere);

        return response;
    }

    public List<NoiseBlackListResponse> addBlackList(String type, List<String> list)
    {
        List<NoiseBlackListResponse> response =null;

        if("severe".equalsIgnoreCase(type))
            response = addToBlackList(type, severeNoise, list);
        else
            response = addToBlackList(type, moderateNoise, list);

        return response;
    }

    private List<NoiseBlackListResponse> addToBlackList(String type, Set<String> severeNoise, List<String> list) {

        List<NoiseBlackListResponse> response = new ArrayList<>(list.size());

        for(String noise:list)
        {
            NoiseBlackListResponse noiseOperationResponse =  new NoiseBlackListResponse();
            noiseOperationResponse.setNoise(noise);
            noiseOperationResponse.setType(type);

            if(severeNoise.add(noise))
            {
                noiseOperationResponse.setNoiseId(UUID.randomUUID());
            }
            else
            {
                noiseOperationResponse.setError("Already exists!");
            }

            response.add(noiseOperationResponse);
        }

        return response;
    }

    public List<NoiseBlackListResponse> updateBlackList(String type, List<String> list)
    {
        List<NoiseBlackListResponse> response = null;

        return response;
    }

    public List<NoiseBlackListResponse> deleteNoise(String type, List<String> list)
    {
        List<NoiseBlackListResponse> response = null;

        return response;
    }

    private List<String>  locateNoise(List<String> allWords, ArrayList<String> listOfNoise) {

        return  allWords
                .parallelStream()
                .filter(listOfNoise::contains)
                .collect(toList());
    }
}
