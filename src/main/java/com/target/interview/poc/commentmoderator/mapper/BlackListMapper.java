package com.target.interview.poc.commentmoderator;

import com.target.interview.poc.commentmoderator.data.CommentValidationResponse;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by m0m0180 on 8/15/18.
 */
public class BlackListMapper implements RowMapper<CommentValidationResponse> {

    @Nullable
    @Override
    public CommentValidationResponse mapRow(ResultSet resultSet, int i) throws SQLException {

        CommentValidationResponse commentValidationResponse = new CommentValidationResponse();

        return null;
    }
}
