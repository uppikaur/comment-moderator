package com.target.interview.poc.commentmoderator.repo;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by m0m0180 on 8/15/18.
 */
@Repository
public class NoiseRespository {

    List<String>  noizeList = new ArrayList<>();

    {
        noizeList.add("bad");
    }

    public List<String> findMatchingNoize(String comment)
    {
        ArrayList<String> noiseInCurrentComment = new ArrayList<>(noizeList);
        String[] split = comment.split(" ");
        List<String> allWords = Arrays.asList(split);

        List<String> collect = allWords
                .parallelStream()
                .filter(noiseInCurrentComment::contains)
                .collect(toList());

        return collect;
    }
}
