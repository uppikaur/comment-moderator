package com.target.interview.poc.commentmoderator.resource;

import com.target.interview.poc.commentmoderator.data.Comment;
import com.target.interview.poc.commentmoderator.data.CommentValidationResponse;
import com.target.interview.poc.commentmoderator.data.dboperations.NoiseBlackListRequest;
import com.target.interview.poc.commentmoderator.data.dboperations.NoiseBlackListResponse;
import com.target.interview.poc.commentmoderator.repo.NoiseRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("noise")
public class NoiseBlackList {

    private static final Logger LOGGER= LoggerFactory.getLogger(NoiseBlackList.class);

    @Autowired
    private NoiseRespository noiseRespository;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<List<NoiseBlackListResponse>> addNoise(@RequestBody NoiseBlackListRequest request)
    {
        LOGGER.info("Add Request  : {}", request);

        List<NoiseBlackListResponse> response =
                noiseRespository.addBlackList(request.getType(),request.getNoiseList());

        LOGGER.info("Add Response  : {}", response);

        return ResponseEntity.ok().body(response);

    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<List<NoiseBlackListResponse>> deleteNoise(@RequestBody NoiseBlackListRequest request)
    {
        LOGGER.info("Add Request  : {}", request);

        List<NoiseBlackListResponse> response =
                noiseRespository.deleteNoise(request.getType(),request.getNoiseList());

        LOGGER.info("Add Response  : {}", response);

        return ResponseEntity.ok().body(response);

    }
}
