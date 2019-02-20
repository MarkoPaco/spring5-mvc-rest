package guru.springfamework.controllers.v1;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CategoryListDTO;
import guru.springfamework.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    public static final String BASE_URL = "/api/v1/categories";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Old version without RestController annotation
    /*@GetMapping
    public ResponseEntity<CategoryListDTO> getAllCategories(){

        return new ResponseEntity<CategoryListDTO>(
                new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
    }*/

    //With RestController annotation we automatically return a ResponseBody
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories() {
        return new CategoryListDTO(categoryService.getAllCategories());
    }

    //Old version without RestController annotation
    /*@GetMapping("{name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String name) {
        return new ResponseEntity<CategoryDTO>(
                categoryService.getCategoryByName(name), HttpStatus.OK
        );
    }*/

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }
}
