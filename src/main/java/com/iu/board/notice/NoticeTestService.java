package com.iu.board.notice;

import java.util.Random;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iu.file.FileDAO;
import com.iu.file.FileDTO;

@Service

public class NoticeTestService {
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private FileDAO fileDAO;
	
	
	public void insert(NoticeDTO noticeDTO, FileDTO fileDTO) throws Exception {
		noticeDAO.insert(noticeDTO);
		
		fileDAO.insert(fileDTO);
		
	}

}
