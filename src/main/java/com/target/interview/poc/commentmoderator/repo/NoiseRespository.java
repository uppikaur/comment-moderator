package com.target.interview.poc.commentmoderator.repo;

import com.target.interview.poc.commentmoderator.data.CommentValidationResponse;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Repository
public class NoiseRespository {

    List<String> severeNoise = new ArrayList<>();

    {
        severeNoise.add("ugly");
    }

    List<String> moderateNoise = new ArrayList<>();

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

    private List<String>  locateNoise(List<String> allWords, ArrayList<String> listOfNoise) {

        return  allWords
                .parallelStream()
                .filter(listOfNoise::contains)
                .collect(toList());
    }
}
