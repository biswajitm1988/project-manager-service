package com.fsd.service.project.manager;

import com.fsd.service.project.manager.entity.Project;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProjectManagerServiceTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/task/manager";
    }

    /**
     * Here we test that we can get all the Projects in the database
     * using the GET method
     */
    @Test
    public void testGetAllProjects() {

        ResponseEntity<List> response = restTemplate.exchange(getRootUrl() + "/getAllProjects",
                HttpMethod.GET, new HttpEntity<String>(null, new HttpHeaders()), List.class);

        System.out.println(response.getBody().get(0));
        Assert.assertNotNull(response.getBody());
        Assert.assertTrue(!response.getBody().isEmpty());
    }

    /**
     * Here we test that we can fetch a single Project using its id
     */
    @Test
    public void testGetProjectById() {
        Long id =1l;
        Project project = restTemplate.getForObject(getRootUrl() + "/getProjectById/"+id, Project.class);

       // System.out.println(project.getProjectSummary());
        Assert.assertNotNull(project);
    }

    /**
     * Here we test that we can create a task using the POST method
     */
    @Test
    public void testCreateAndDeleteProject() {
        Project project = new Project();
        //project.setProjectName();

        ResponseEntity<Project> postResponse = restTemplate.postForEntity(getRootUrl() + "/addProject", project, Project.class);
        Project newProject = postResponse.getBody();
       /* Assert.assertEquals(project.getProjectSummary(), newProject.getProjectSummary());
        Assert.assertEquals(project.getParentProject().getParentProjectSummary(), newProject.getParentProject().getParentProjectSummary());*/

        //Delete newly Created Project
        /*System.out.println("Calling Delete Project");
        restTemplate.delete(getRootUrl() + "/deleteProject/"+ newProject.getProjectId());
        Project tempProject = restTemplate.getForObject(getRootUrl() + "/getProjectById/" + newProject.getProjectId(), Project.class);
        System.out.println("After Delete Project"+ tempProject);
        Assert.assertNull(tempProject);*/
    }

    /**
     * Here we test that we can update a task's information using the PUT method
     */
    @Test
    public void testUpdateProject() {
        /*Long id = 1l;
        Project project = restTemplate.getForObject(getRootUrl() + "/getProjectById/" + id, Project.class);
        Project tempProject = new Project();
        BeanUtils.copyProperties(project, tempProject);
        ParentProject pt = new ParentProject();
        pt.setParentProjectSummary("Test Parent Project PUT");
        project.setProjectSummary("Test Project PUT");
        project.setPriority(9);
        project.setStartDate(new Date());
        project.setParentProject(pt);

        restTemplate.put(getRootUrl() + "/updateProject", project);

        Project updatedProject = restTemplate.getForObject(getRootUrl() + "/getProjectById/" + id, Project.class);
        System.out.println(updatedProject.getProjectSummary());
        Assert.assertEquals(project.getProjectSummary(), updatedProject.getProjectSummary());*/

        //Put back Original Project
        /*System.out.println("Put Back Original Project");
        restTemplate.put(getRootUrl() + "/updateProject", tempProject);
        updatedProject = restTemplate.getForObject(getRootUrl() + "/getProjectById/" + id, Project.class);
        Assert.assertEquals(tempProject.getProjectSummary(), updatedProject.getProjectSummary());*/
    }
}
