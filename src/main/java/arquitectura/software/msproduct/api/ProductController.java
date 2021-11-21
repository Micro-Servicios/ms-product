package arquitectura.software.msproduct.api;

import arquitectura.software.msproduct.entity.Product;
import arquitectura.software.msproduct.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {

    private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductRepository productRepository;
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public Product saveCustomer(@RequestBody Product product){
        System.out.println("REGISTRAR EL PRODUCTO desde el puerto: "+serverPort);
        LOGGER.info("SE REGISTRO EL PRODUCTO");
        return productRepository.save(product);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public Product updateCustomer(@RequestBody Product product){
        System.out.println("ACTULIZACION DE EL PRODUCTO desde el puerto: "+serverPort);

        LOGGER.info("SE ACTULIZO EL PRODUCTO");
        return productRepository.save(product);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<Product> getAllCustomer(){

        LOGGER.info("SE ENCONTRO LOS PRODUCTOS");
        return productRepository.findAll();
    }

    @RequestMapping(path = "/productId", method = RequestMethod.GET)
    public Boolean getValueProductId(@RequestParam Integer productId){
        Optional<Product> productOptional =productRepository.findById(productId);
        if(productOptional.isPresent()){

            LOGGER.info("SE ENCONTRO EL PRODUCTO");
            return true;
        }else{
            LOGGER.error("NO EXISTE EL PRODUCTO");
            return false;
        }
    }
}
