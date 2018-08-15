package com.target.interview.poc.commentmoderator.mapper;

import com.target.interview.poc.commentmoderator.constants.DataBaseConstats;
import com.target.interview.poc.commentmoderator.data.CommentValidationResponse;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class BlackListMapper implements RowMapper<NoiseDaoTO> {

    @Nullable
    @Override
    public NoiseDaoTO mapRow(ResultSet resultSet, int i) throws SQLException {

        NoiseDaoTO commentValidationResponse = new NoiseDaoTO();
        commentValidationResponse.setName(resultSet.getString(DataBaseConstats.NOISE_NAME));
        commentValidationResponse.setType(resultSet.getString(DataBaseConstats.NOISE_TYPE));
        return commentValidationResponse;
    }
}
