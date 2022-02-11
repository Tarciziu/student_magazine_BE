package main.mapper;

import main.controller.response.ArticleResponse;
import main.controller.response.UserProfileDTO;
import main.domain.Article;
import main.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    private ModelMapper modelMapper;

    public ArticleResponse convertToArticleDTO(Article article) {
        ArticleResponse response = new ArticleResponse();
        response.setId(article.getId());
        response.setTitle(article.getTitle());
        response.setText(article.getText());
        response.setAuthorName(article.getAuthor().getFirstName() + " " + article.getAuthor().getLastName());
        response.setDate(article.getDate());
        return response;
    }

    public UserProfileDTO convertToUserProfileDTO(User user) {
        UserProfileDTO dto = new UserProfileDTO();

        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setBirthDate(user.getBirthDate());

        return dto;
    }

}
