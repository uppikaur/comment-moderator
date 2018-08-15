package com.target.interview.poc.commentmoderator.resource;

import com.target.interview.poc.commentmoderator.data.Comment;
import com.target.interview.poc.commentmoderator.repo.NoiseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by m0m0180 on 8/15/18.
 */
@RestController
@RequestMapping("comments")
public class CommentModerator {


    @Autowired
    private NoiseRespository noiseRespository;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<String> validateComment(@RequestBody Comment request)
    {
        List<String> matchingNoize = noiseRespository.findMatchingNoize(request.getComment());
        return ResponseEntity.ok().body(matchingNoize.toString());

    }

}
