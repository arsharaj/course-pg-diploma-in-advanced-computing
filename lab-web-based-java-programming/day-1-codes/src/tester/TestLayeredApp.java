package tester;

import java.util.List;
import java.util.Scanner;

import dao.CandidateDaoImpl;
import pojos.Candidate;

public class TestLayeredApp {
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			CandidateDaoImpl daoInstance = new CandidateDaoImpl();
			List<Candidate> allCandidates = daoInstance.getAllCandidates();
			allCandidates.forEach(System.out::println);
			daoInstance.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
