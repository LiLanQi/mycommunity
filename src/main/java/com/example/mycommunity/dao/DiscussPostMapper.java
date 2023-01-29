package com.example.mycommunity.dao;

import com.example.mycommunity.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    // 考虑到后期分页功能加入offset 和 limit变量
    // 在这里加入userid是为了查找特定用户发的的帖子（如果传入的userid=0，查找的就是所有的帖子）
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // @Param注解用于给参数取别名,
    // 如果只有一个参数,并且在<if>里使用,则必须加别名.
    // 查询总的帖子条数，如果传入userid，则查询特定用户发的帖子条数，如果传入0，则查询所有
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);

}
