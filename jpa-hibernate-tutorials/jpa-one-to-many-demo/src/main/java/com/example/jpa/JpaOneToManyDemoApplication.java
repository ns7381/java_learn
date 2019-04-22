package com.example.jpa;

import com.example.jpa.model.Comment;
import com.example.jpa.model.Post;
import com.example.jpa.repository.CommentRepository;
import com.example.jpa.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
//@EnableJpaAuditing
public class JpaOneToManyDemoApplication implements CommandLineRunner {
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private CommentRepository commentRepository;
	public static void main(String[] args) {
		SpringApplication.run(JpaOneToManyDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Clean up database tables
		commentRepository.deleteAllInBatch();
		postRepository.deleteAllInBatch();

		//=========================================

		// Create a Post instance
		Post post = new Post();
		post.setTitle("test title");
		post.setContent("test content");
		post.setDescription("desc");
		post.setCreatedAt(new Date());
		post.setUpdatedAt(new Date());
		Comment comment = new Comment();
		comment.setPost(post);
		comment.setText("text");
		comment.setCreatedAt(new Date());
		comment.setUpdatedAt(new Date());
		Comment comment2 = new Comment();
		comment2.setPost(post);
		comment2.setText("text2");
		comment2.setCreatedAt(new Date());
		comment2.setUpdatedAt(new Date());
		// Save Parent Reference (which will save the child as well)
		postRepository.save(post);

	}
}
