package com.careerdevs.jsonplaceholderv2;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/json")
public class JsonController {

    @GetMapping("/test")
    public String test() {
        return "Test worked!";
    }

    @GetMapping("/getAllPosts")
    public Object getPosts(RestTemplate restTemplate) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/", Object.class);
    }

    @GetMapping("/getPostById/{id}")
    public Object getPostById(RestTemplate restTemplate, @PathVariable String id) {
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id, Object.class);
    }

    @GetMapping("posts/{id}/comments")
    public Object getCommentsByPost(RestTemplate restTemplate, @PathVariable String id){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/" + id + "/comments", Object.class);
    }

    @GetMapping("/comments")
    public Object getCommentsByPostQuery(RestTemplate restTemplate, @RequestParam String id){
        return restTemplate.getForObject("https://jsonplaceholder.typicode.com/comments?postId=" + id, Object.class);
    }

    @PostMapping("/posts")
    public Post createPost(RestTemplate restTemplate, @RequestBody Post newPost){
        /*
        postForObject takes 3 args
        * 1. URL
        * 2. Request body
        * 3. Return type
        */
        return restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts/", newPost, Post.class);
    }

    @PutMapping("posts/{id}")
    public String updatePost(RestTemplate restTemplate, @PathVariable int id, @RequestBody Post post) {
        restTemplate.put("https://jsonplaceholder.typicode.com/posts/" + id, post);
        return "Post with id " + id + "successfully updated";
    }

    @DeleteMapping("/posts/{id}")
    public String deletePost(RestTemplate restTemplate, @PathVariable int id){
        restTemplate.delete("https://jsonplaceholder.typicode.com/posts/" + id);
        return "Deleted post with ID " + id;
    }

}


