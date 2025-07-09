package com.example.crm.service;

import com.example.crm.entity.ProjectMember;
import com.example.crm.repository.ProjectMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberService {
    @Autowired
    private ProjectMemberRepository projectMemberRepository;

    // Lấy tất cả thành viên dự án
    public List<ProjectMember> getAllProjectMembers() {
        return projectMemberRepository.findAll();
    }

    // Tạo mới thành viên dự án
    public ProjectMember createProjectMember(ProjectMember pm) {
        return projectMemberRepository.save(pm);
    }

    // Xóa thành viên dự án
    public void deleteProjectMember(Long id) {
        projectMemberRepository.deleteById(id);
    }
}
