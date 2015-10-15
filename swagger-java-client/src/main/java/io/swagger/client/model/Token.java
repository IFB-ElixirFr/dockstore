package io.swagger.client.model;

import io.swagger.client.StringUtil;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2015-10-05T12:31:03.778-04:00")
public class Token   {
  
  private Long id = null;
  private String tokenSource = null;
  private String content = null;
  private Long userId = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("id")
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("tokenSource")
  public String getTokenSource() {
    return tokenSource;
  }
  public void setTokenSource(String tokenSource) {
    this.tokenSource = tokenSource;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("content")
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("userId")
  public Long getUserId() {
    return userId;
  }
  public void setUserId(Long userId) {
    this.userId = userId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("    id: ").append(StringUtil.toIndentedString(id)).append("\n");
    sb.append("    tokenSource: ").append(StringUtil.toIndentedString(tokenSource)).append("\n");
    sb.append("    content: ").append(StringUtil.toIndentedString(content)).append("\n");
    sb.append("    userId: ").append(StringUtil.toIndentedString(userId)).append("\n");
    sb.append("}");
    return sb.toString();
  }
}