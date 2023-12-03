package br.teste.photon;

import com.netflix.imflibrary.MXFUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.imflibrary.MXFDataDefinition;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/photon/")
public class PhotonController {

    @PostMapping
    public ResponseEntity<?> defineData(
            @RequestBody MultipartFile file
    ){

        try{
            MXFDataDefinition definition = MXFDataDefinition.getDataDefinition(new MXFUID(file.getBytes()));

            return ResponseEntity.ok(definition.toString());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Não foi possível decodificar o seu arquivo");
        }



    }

}
