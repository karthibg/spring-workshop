package ch.asmiq.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.asmiq.interfaces.CertificationService;
import ch.asmiq.model.Order;
import ch.karthi.certification.KarthiCertificationValidator;

@Service
public class AsmiqCertificationService implements CertificationService {

	private static final Logger LOG = Logger.getLogger(AsmiqCertificationService.class.getName());

	private KarthiCertificationValidator karthiCertificationValidator;

	public void downloadCertificate(Order order) {
		if (karthiCertificationValidator.isValid()) {
			LOG.info("Certificate Downloaded!!");
		} else {
			throw new RuntimeException("Invalid Certificate");
		}
	}
	
	@Autowired
	public void setKarthiCertificationValidator(KarthiCertificationValidator karthiCertificationValidator) {
		this.karthiCertificationValidator = karthiCertificationValidator;
	}

}
