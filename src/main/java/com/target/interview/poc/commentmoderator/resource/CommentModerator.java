package com.target.interview.poc.commentmoderator.resource;

import com.target.interview.poc.commentmoderator.data.Comment;
import com.target.interview.poc.commentmoderator.data.CommentValidationResponse;
import com.target.interview.poc.commentmoderator.repo.NoiseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
public class CommentModerator {


    @Autowired
    private NoiseRespository noiseRespository;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<CommentValidationResponse> validateComment(@RequestBody Comment request)
    {
        CommentValidationResponse matchingNoiseResponse =
                noiseRespository.findMatchingNoise(request.getComment());
        return ResponseEntity.ok().body(matchingNoiseResponse);

    }

}
