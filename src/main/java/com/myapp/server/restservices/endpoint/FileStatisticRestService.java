package com.myapp.server.restservices.endpoint;

import com.myapp.server.restservices.dto.FileDto;
import com.myapp.server.restservices.dto.FileStatisticDto;
import com.myapp.server.restservices.entities.File;
import com.myapp.server.restservices.entities.FileStatistic;
import com.myapp.server.restservices.entities.LineStatistic;
import com.myapp.server.restservices.service.FileStatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Path("/files")
public class FileStatisticRestService {

	@Autowired
	private FileStatService fileStatService;

	@Autowired
	private ModelMapper modelMapper;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFiles() {
		List<File> files = fileStatService.getAllFiles();
		return Response.ok(files.stream()
				.map(file -> modelMapper.map(file, FileDto.class))
				.collect(Collectors.toList()))
				.build();
	}

	@GET
	@Path("/{fileId}/stat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFileStatisticById(@PathParam("fileId") int fileId) {
		List<FileStatistic> fileStatistic = fileStatService.getFileStatisticById(fileId);
		if (fileStatistic.isEmpty()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		return Response.ok().entity(fileStatistic.stream()
				.map(fileStat -> modelMapper.map(fileStat, FileStatisticDto.class))
				.collect(Collectors.toList()))
				.build();
	}

	@GET
	@Path("/{fileId}/lines_stat")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLinesStatisticByFileId(@PathParam("fileId") int fileId) {
		List<LineStatistic> lineStatistics = fileStatService.getLinesStatisticByFileId(fileId);
		if (lineStatistics.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok().entity(lineStatistics.stream()
				.map(lineStat -> modelMapper.map(lineStat, LineStatistic.class))
				.collect(Collectors.toList()))
				.build();
	}
}
