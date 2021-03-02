package com.milelu;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author MILELU
 * @date 2021/2/24 23:58
 */
//@RequestMapping("/fucking")
public interface Api {
    @GetMapping("/alive")
    Map alive();

    @GetMapping("/byId/{id}")
    Map byId(@PathVariable("id") Integer id);

    @PostMapping(value = "/updateUser")
    Map<String, Object> updateUser(@RequestBody Map<String, Object> map);
}
