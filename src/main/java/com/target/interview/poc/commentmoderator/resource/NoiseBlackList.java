package com.target.interview.poc.commentmoderator.resource;

import com.target.interview.poc.commentmoderator.data.Comment;
import com.target.interview.poc.commentmoderator.data.CommentValidationResponse;
import com.target.interview.poc.commentmoderator.data.dboperations.NoiseBlackListRequest;
import com.target.interview.poc.commentmoderator.data.dboperations.NoiseBlackListResponse;
import com.target.interview.poc.commentmoderator.repo.NoiseRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("noise")
public class NoiseBlackList {

    @Autowired
    private NoiseRespository noiseRespository;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<List<NoiseBlackListResponse>> addNoise(@RequestBody NoiseBlackListRequest request)
    {
        List<NoiseBlackListResponse> response =
                noiseRespository.addBlackList(request.getType(),request.getNoiseList());
        return ResponseEntity.ok().body(response);

    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<List<NoiseBlackListResponse>> updateNoise(@RequestBody NoiseBlackListRequest request)
    {
        List<NoiseBlackListResponse> response =
                noiseRespository.updateBlackList(request.getType(),request.getNoiseList());
        return ResponseEntity.ok().body(response);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<List<NoiseBlackListResponse>> deleteNoise(@RequestBody NoiseBlackListRequest request)
    {
        List<NoiseBlackListResponse> response =
                noiseRespository.deleteNoise(request.getType(),request.getNoiseList());
        return ResponseEntity.ok().body(response);

    }
}
