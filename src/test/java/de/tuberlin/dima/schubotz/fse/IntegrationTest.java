package de.tuberlin.dima.schubotz.fse;

import org.junit.Test;

import eu.stratosphere.api.common.Plan;
import eu.stratosphere.api.java.ExecutionEnvironment;
import eu.stratosphere.client.LocalExecutor;

public class IntegrationTest {
    @Test
    public void TestLocalExecution() throws Exception {
    	try {
	        String inputFilename = "file://" + getClass().getClassLoader().getResources("test1000.xml").nextElement().getPath(); //DEBUG input filename
	        System.out.println("Integration testing on: " + inputFilename);
	        String queryFile = "file://" + getClass().getClassLoader().getResources("fQuery.xml").nextElement().getPath();
	        String outputFilename = "file://" + getClass().getClassLoader().getResources("test.out").nextElement().getPath();
	        String keywordDocsFilename = "file://" + getClass().getClassLoader().getResources("keywordDocsMap.csv").nextElement().getPath();
	        String latexDocsFilename = "file://" + getClass().getClassLoader().getResources("latexDocsMap.csv").nextElement().getPath();
			//DEBUG file IO
			keywordDocsFilename = "/home/jjl4/keywordDocsMap.csv";
			latexDocsFilename = "/home/jjl4/latexDocsMap.csv";
			outputFilename = "/home/jjl4/output.csv";
	        
	        
	        MainProgram.parseArg(new String[]{"16", inputFilename,
	        								  queryFile, outputFilename + Math.random() * Integer.MAX_VALUE,
	        								  keywordDocsFilename, latexDocsFilename,
	        								  "999"}); //DEBUG input numdoc
	        MainProgram.ConfigurePlan();
	        ExecutionEnvironment env = MainProgram.getExecutionEnvironment();
	        Plan plan = env.createProgramPlan();//rc.getPlan(inputFilename, outputFilename + Math.random() * Integer.MAX_VALUE, "1.5", "0");
	        LocalExecutor.execute(plan);
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
}