package com.example.crm.service;

import com.example.crm.entity.Project;
import com.example.crm.entity.ProjectMember;
import com.example.crm.entity.User;
import com.example.crm.repository.ProjectMemberRepository;
import com.example.crm.repository.ProjectRepository;
import com.example.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Service quản lý dự án
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    // Lấy tất cả dự án (Admin)
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Lấy dự án theo id
    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElseThrow();
    }

    // Tạo mới dự án (Leader)
    public Project createProject(Project project, Long leaderId) {
        User leader = userRepository.findById(leaderId).orElseThrow();
        project.setLeader(leader);
        return projectRepository.save(project);
    }

    // Sửa dự án (Leader)
    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id).orElseThrow();
        project.setName(projectDetails.getName());
        project.setDescription(projectDetails.getDescription());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        return projectRepository.save(project);
    }

    // Xoá dự án (Leader)
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    // Thêm thành viên vào dự án (Leader)
    public void addMember(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        ProjectMember pm = new ProjectMember();
        pm.setProject(project);
        pm.setUser(user);
        projectMemberRepository.save(pm);
    }

    // Xoá thành viên khỏi dự án (Leader)
    public void removeMember(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        List<ProjectMember> members = projectMemberRepository.findByProject(project);
        for (ProjectMember pm : members) {
            if (pm.getUser().getId().equals(userId)) {
                projectMemberRepository.delete(pm);
                break;
            }
        }
    }

    // Lấy danh sách thành viên của dự án (Leader)
    public List<ProjectMember> getMembers(Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        return projectMemberRepository.findByProject(project);
    }

    // Lấy danh sách dự án do leader quản lý
    public List<Project> getProjectsByLeader(Long leaderId) {
        User leader = userRepository.findById(leaderId).orElseThrow();
        return projectRepository.findByLeader(leader);
    }
}
