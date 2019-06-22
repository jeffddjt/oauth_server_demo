package cn.xyvideo.sso.controller;

import cn.xyvideo.sso.model.OauthClient;
import cn.xyvideo.sso.service.ClientService;
import cn.xyvideo.sso.utils.XYResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("manage")
    public String manage(Model model){
        model.addAttribute("clients",this.clientService.getAll());
        return "client_management";
    }

    @GetMapping("add")
    public String add(){
        return "add_client";
    }

    @PostMapping("add")
    public String add(OauthClient client){
        this.clientService.add(client);
        return "redirect:manage";
    }

    @GetMapping("modify")
    public String modify(@RequestParam(name="id",defaultValue = "0") long id,Model model){
        OauthClient client = this.clientService.getClientById(id);
        model.addAttribute("client",client);
        return "modi_client";
    }

    @PostMapping("modify")
    public String modify(OauthClient client){
        this.clientService.modify(client);
        return "redirect:manage";
    }

    @PostMapping("delete")
    @ResponseBody
    public XYResult delete(@RequestParam(name = "id",defaultValue = "0") long id){
        if(id==0){
            return new XYResult(0,"参数不正确!");
        }

        this.clientService.deleteById(id);
        return new XYResult(1,"删除成功!");
    }
}
