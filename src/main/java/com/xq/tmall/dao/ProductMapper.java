package com.xq.tmall.dao;

import com.xq.tmall.entity.Product;
import com.xq.tmall.util.OrderUtil;
import com.xq.tmall.util.PageUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

@Repository
public interface ProductMapper {
    Integer insertOne(@Param("product") Product product);

    Integer updateOne(@Param("product") Product product);

    List<Product> select(@Param("product") Product product, @Param("product_isEnabled_array") Byte[] product_isEnabled_array, @Param("orderUtil") OrderUtil orderUtil, @Param("pageUtil") PageUtil pageUtil);

    List<Product> selectTitle(@Param("product") Product product, @Param("pageUtil") PageUtil pageUtil);

    Product selectOne(@Param("product_id") Integer product_Id);

    Integer selectTotal(@Param("product") Product product, @Param("product_isEnabled_array") Byte[] product_isEnabled_array);

    List<Product> selectMoreList(@Param("product") Product product, @Param("product_isEnabled_array") Byte[] bytes, @Param("orderUtil") OrderUtil orderUtil, @Param("pageUtil") PageUtil pageUtil, @Param("product_name_split") String[] product_name_split);

    Integer selectMoreListTotal(@Param("product") Product product, @Param("product_isEnabled_array") Byte[] product_isEnabled_array, @Param("product_name_split") String[] product_name_split);

    @Delete("<script>" +
            "DELETE FROM product WHERE product_id IN " +
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    Integer deleteBatchIds(@Param("ids") List<Integer> ids);
}
