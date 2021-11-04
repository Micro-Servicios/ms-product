package arquitectura.software.msproduct.api;

import arquitectura.software.msproduct.entity.Product;
import arquitectura.software.msproduct.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {


    @Autowired
    private ProductRepository productRepository;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Product saveCustomer(@RequestBody Product product){
        System.out.println("REGISTRAR EL PRODUCTO desde el puerto: "+serverPort);
        return productRepository.save(product);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Product> getAllCustomer(){
        return productRepository.findAll();
    }


}
