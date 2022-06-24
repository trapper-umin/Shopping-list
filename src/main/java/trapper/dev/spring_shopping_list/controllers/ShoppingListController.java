package trapper.dev.spring_shopping_list.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import trapper.dev.spring_shopping_list.persist.ShoppingItem;
import trapper.dev.spring_shopping_list.persist.ShoppingItemRepository;

@Controller
public class ShoppingListController {

    private ShoppingItemRepository repository;

    @Autowired
    public ShoppingListController(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String indexPage(Model model){
        model.addAttribute("items", repository.findAll());
        model.addAttribute("item", new ShoppingItem());
        return "index";
    }

    @PostMapping
    public String newShoppingItem(ShoppingItem shoppingItem){
        repository.save(shoppingItem);
        return "redirect:/";
    }
}
