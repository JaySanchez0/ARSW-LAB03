package edu.eci.arsw.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;


@Service
public class GrammarChecker {
        @Autowired
        //@Qualifier("EnglishSpellChecker")
        @Qualifier("SpanishSpellChecker")
	SpellChecker sc;

	String x;
        
        
	public SpellChecker getSpellChecker() {
		return sc;
	}

	public void setSpellChecker(SpellChecker sc) {
		this.sc = sc;
	}


	public String check(String text){
		
		StringBuffer sb=new StringBuffer();
		sb.append("Spell checking output:"+sc.checkSpell(text));
		sb.append("Plagiarism checking output: Not available yet");
		
		
		return sb.toString();
		
	}
        public static void main(String[] args) {
            ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
            GrammarChecker gc=ac.getBean(GrammarChecker.class);
            System.out.println(gc.check("la la la "));
        }
	
	
}
