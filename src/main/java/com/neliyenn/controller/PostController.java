package com.neliyenn.controller;

import com.neliyenn.model.Post;
import com.neliyenn.model.User;
import com.neliyenn.service.PostService;
import com.neliyenn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public ModelAndView newPost(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByUsername(principal.getName());
        Post post = new Post();
        post.setUser(user);
        modelAndView.addObject("post", post);
        modelAndView.setViewName("postForm");
        return modelAndView;
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public ModelAndView createNewPost(@Valid Post post, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("postForm");
        } else {
            postService.savePost(post);
            modelAndView.setViewName("redirect:/blog/" + post.getUser().getUsername());
        }
        return modelAndView;
    }


    @RequestMapping(value = "/editPost/{id}", method = RequestMethod.GET)
    public ModelAndView editPostWithId(@PathVariable Long id, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        Post post = postService.findPostForId(id);

        if (principal == null || !principal.getName().equals(post.getUser().getUsername())) {
            modelAndView.setViewName("403");
        }

        if (post == null) {
            modelAndView.setViewName("404");
        }
        else {
            modelAndView.addObject("post", post);
            modelAndView.setViewName("postForm");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.DELETE)
    public ModelAndView deletePostWithId(@PathVariable Long id, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        Post post = postService.findPostForId(id);

        if (post == null) {
            modelAndView.setViewName("error");
        }
        else if (principal == null || !principal.getName().equals(post.getUser().getUsername())) {
            modelAndView.setViewName("403");
        }
        else {
            postService.delete(post);
            modelAndView.setViewName("redirect:/home");
        }
        return modelAndView;
    }
}
