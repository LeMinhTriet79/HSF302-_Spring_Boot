package com.example.crm.repository;

import com.example.crm.entity.Project;
import com.example.crm.entity.ProjectMember;
import com.example.crm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// Repository quản lý bảng ProjectMember (thành viên dự án)
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
    // Lấy danh sách thành viên thuộc một project
    List<ProjectMember> findByProject(Project project);

    // Lấy danh sách dự án mà user tham gia
    List<ProjectMember> findByUser(User user);

    // Xóa thành viên khỏi dự án (tìm 1 record theo project và user)
    void deleteByProjectAndUser(Project project, User user);
}
