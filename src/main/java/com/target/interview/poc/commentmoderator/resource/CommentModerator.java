package com.target.interview.poc.commentmoderator.resource;

import com.target.interview.poc.commentmoderator.data.Comment;
import com.target.interview.poc.commentmoderator.data.CommentValidationResponse;
import com.target.interview.poc.commentmoderator.repo.NoiseRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
public class CommentModerator {

    private static final Logger LOGGER= LoggerFactory.getLogger(CommentModerator.class);

    @Autowired
    private NoiseRespository noiseRespository;

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public @ResponseBody
    ResponseEntity<CommentValidationResponse> validateComment(@RequestBody Comment request)
    {
        LOGGER.info("Get Request  : {}", request);

        CommentValidationResponse matchingNoiseResponse =
                noiseRespository.findMatchingNoise(request.getComment());

        LOGGER.info("Get Response : {}", matchingNoiseResponse);

        return ResponseEntity.ok().body(matchingNoiseResponse);

    }

}
