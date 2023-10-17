package Controllers;

import Repositories.ModelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {

    private final ModelRepository modelRepository;

    //inject modelRepository
    public ModelController(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    @RequestMapping("/models")
    public String getModels(Model model) {

        model.addAttribute("models",modelRepository.findAll());

        return "models/list";
    }


}
