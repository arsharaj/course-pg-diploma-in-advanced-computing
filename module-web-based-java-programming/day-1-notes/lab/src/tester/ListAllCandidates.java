package tester;

import java.util.Scanner;

import dao.CandidateDaoImpl;

public class ListAllCandidates {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create dao instance
			CandidateDaoImpl dao=new CandidateDaoImpl();
			System.out.println("All candidates");
			dao.getAllCandidates().forEach(System.out::println);
				//clean up
			dao.cleanUp();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
