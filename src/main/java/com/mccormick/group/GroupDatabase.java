package com.mccormick.group;

import com.mccormick.User.User;

import java.util.LinkedList;
import java.util.List;

public class GroupDatabase {

	private List<Group> groupList;

	public GroupDatabase() {
		groupList = List.of(
				new Group("First Group", new User("Egor Bessonov", "123"), new LinkedList<>()),
				new Group("Second Group", new User("Nikita Fomin", "IloveBeer"), new LinkedList<>()),
				new Group("Third Group", new User("alexkrug", "IloveDM"), new LinkedList<>()),
				new Group("Fourth Group", new User("Egor Bessonov", "123"), new LinkedList<>())
		);
	}

	public Group getGroupByName(String groupName) {
		for (Group g : this.groupList) {
			if (g.getName().equals(groupName)) {
				return g;
			}
		}
		return null;
	}

	public List<Group> getGroupListByOwner(User owner) {
		List<Group> result = new LinkedList<>();
		for (Group g : this.groupList) {
			if (owner.getUserName().equals(g.getOwner().getUserName())) {
				result.add(g);
			}
		}

		return result;
	}

	public Group deleteByName(String groupName) {
		for (Group g : this.groupList) {
			if (g.getName().equals(groupName)) {
				this.groupList.remove(g);
			}
		}

		return null;
	}

	public boolean addGroup(Group group) {
		for (Group g : this.groupList) {
			if (group.getName().equals(g.getName())) {
				return false;
			}
		}

		return this.groupList.add(group);
	}
}
