package vmansus.community.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import vmansus.community.model.Comment;
import vmansus.community.model.CommentExample;
import vmansus.community.model.Question;

import java.util.List;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}