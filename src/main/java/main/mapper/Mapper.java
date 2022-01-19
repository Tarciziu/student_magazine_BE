package main.mapper;

import main.controller.response.ArticleResponse;
import main.domain.Article;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    @Autowired
    private ModelMapper modelMapper;

//    public Patient convertToPatient(PatientDTO patientDTO) {
//        Patient patient = modelMapper.map(patientDTO, Patient.class);
//        return patient;
//    }

    public ArticleResponse convertToArticleDTO(Article article) {
        ArticleResponse response = new ArticleResponse();
        response.setTitle(article.getTitle());
        response.setText(article.getText());
        response.setAuthorName(article.getAuthor().getFirstName() + " " + article.getAuthor().getLastName());
        response.setDate(article.getDate());
        return response;
    }

}
