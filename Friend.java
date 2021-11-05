package com.trees.practice;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;

public class Friend {

	private Collection<Friend> friends;
	private String email;

	public Friend(String email) {
		this.email = email;
		this.friends = new ArrayList<Friend>();
	}

	public String getEmail() {
		return email;
	}

	public Collection<Friend> getFriends() {
		return friends;
	}

	public void addFriendship(Friend friend) {
		friends.add(friend);
		friend.getFriends().add(this);
	}

	public boolean canBeconnected(Friend friend) {
		
        Queue<Collection<Friend>> queue = new LinkedList<>();
        queue.add(this.getFriends());
        Set<String> set = new HashSet<>();
        set.add(this.getEmail());
        while (!queue.isEmpty()) {
            Collection<Friend> Collfrnd = queue.poll();
            for(Friend frnd :Collfrnd) {
            	if(frnd.getEmail().equals(friend.getEmail()))
            		return true;
            	else {
            		if(!set.contains(frnd.getEmail())) {
            			queue.add(frnd.getFriends());
            			set.add(frnd.getEmail());
            		}
            	}
            }
           
        }
        
		return false;
		
	}

	public static void main(String[] args) {
		Friend a = new Friend("A");
		Friend b = new Friend("B");
		Friend c = new Friend("C");
		Friend d = new Friend("D");

		a.addFriendship(b);
		b.addFriendship(c);
		//c.addFriendship(d);
		System.out.println(a.canBeconnected(c));
		System.out.println(a.canBeconnected(d));
	}
}
