/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.control;

import integracion.VO.LinkedInProfile;
import integracion.util.LinkedInApi;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class LinkedIn {
    
     
    public String ConsultarPersona() throws IOException, Exception{
        LinkedInProfile linkedInProfile = new LinkedInProfile();
        LinkedInApi linkedInApi = new LinkedInApi();
        String code = "AQQI-Dyy6TeScf548qKW7VSD2-m6thBY150UOEXKhJirmfExioO13OACsiqXrWwXTb4vUlH0sh7BKSTHlqQGKf_hFiK3OMLBys_YB_UzJ2U21U1yeOMRq2PJZCz7NNvVzcHPOZJz9mTjQZjgMPhyCebNN53SP8g-eOAeGUloOJv3fkznfQd11nFOsth1Rw&state=9frf7o40Bvp1CFsp";
        linkedInProfile = linkedInApi.sendPost(code);
        return code;
    }
         
     
         
}
