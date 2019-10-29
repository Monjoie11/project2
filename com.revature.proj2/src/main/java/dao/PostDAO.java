package dao;

import pojos.Post;

public interface PostDAO {
	public void insertPost(Post p);
	public void removePost(String name);
	public void updatePost(Post p);
}
