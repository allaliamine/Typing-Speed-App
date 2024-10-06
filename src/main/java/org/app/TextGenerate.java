package org.app;

import java.util.*;

public class TextGenerate {

    public static List<String> words = new ArrayList<>(Arrays.asList(
            "abandon", "ability", "able", "about", "above", "absent", "absorb", "abstract",
            "abuse", "academy", "accept", "access", "accident", "account", "achieve", "acquire",
            "across", "act", "action", "active", "actor", "actress", "actual", "adapt",
            "add", "address", "advance", "advice", "advise", "affect", "afford", "afraid",
            "after", "against", "age", "agency", "agent", "agree", "ahead", "air", "airport",
            "alarm", "album", "alcohol", "alive", "alliance", "allow", "almost", "alone",
            "along", "already", "also", "alter", "although", "always", "amazing", "among",
            "amount", "analyze", "ancient", "anger", "animal", "annual", "answer", "anxiety",
            "anxious", "anyone", "anything", "apology", "appeal", "appear", "application",
            "appoint", "approve", "area", "argue", "arrive", "artist", "aspect", "assault",
            "assert", "assess", "assign", "assist", "assume", "athlete", "attempt", "attend",
            "attract", "average", "avoid", "aware", "balance", "barrier", "base", "battle",
            "beautiful", "before", "believe", "benefit", "beyond", "bitter", "bizarre", "blank",
            "blame", "bloom", "bother", "brave", "break", "brief", "bring", "broad", "brother",
            "build", "busy", "button", "calm", "camera", "can", "cannot", "capture", "care",
            "cause", "center", "change", "charge", "cheer", "choice", "choose", "citizen",
            "classic", "clever", "close", "clue", "coach", "color", "comfort", "common",
            "compare", "complete", "connect", "consider", "continue", "control", "convert",
            "correct", "cost", "create", "current", "damage", "dance", "dark", "data",
            "decrease", "define", "definite", "delight", "deliver", "depend", "describe",
            "design", "desire", "detail", "develop", "direct", "disease", "distance", "divide",
            "doubt", "dream", "drive", "drop", "during", "eager", "educate", "effect",
            "effort", "elect", "emerge", "emotion", "enable", "enjoy", "enough", "ensure",
            "escape", "estimate", "evaluate", "event", "evidence", "exact", "example",
            "exciting", "exist", "expand", "expect", "explain", "explore", "express",
            "extend", "failure", "famous", "favorite", "fear", "feeling", "focus",
            "follow", "force", "forget", "freedom", "friend", "future", "garden", "gather",
            "gentle", "gift", "global", "goal", "gorgeous", "grateful", "great", "greet",
            "grow", "habit", "handle", "happen", "happy", "health", "honest", "hope",
            "host", "human", "impact", "improve", "include", "increase", "inspire",
            "interest", "invest", "invite", "island", "issue", "journey", "judge",
            "knowledge", "language", "leader", "level", "library", "limit", "listen",
            "local", "manage", "market", "master", "measure", "memory", "message",
            "method", "middle", "mind", "moment", "mother", "natural", "nature",
            "nervous", "notice", "observe", "opinion", "option", "organize",
            "package", "pain", "participate", "patient", "peace", "perform",
            "physical", "place", "plan", "popular", "positive", "potential",
            "prepare", "present", "pressure", "private", "project", "promote",
            "protect", "provide", "public", "purpose", "quality", "question",
            "quick", "quiet", "range", "react", "ready", "realize", "reality",
            "receive", "recognize", "record", "reduce", "reflect", "reliable",
            "remove", "repeat", "report", "require", "research", "respect",
            "responsible", "result", "return", "reveal", "safety", "satisfaction",
            "scale", "scene", "scream", "search", "season", "secret", "sensitive",
            "situation", "skill", "smart", "social", "solve", "source",
            "specific", "spirit", "sport", "spread", "standard", "strength",
            "stress", "style", "support", "surprise", "sustain", "table",
            "teacher", "test", "thank", "theory", "thought", "time",
            "topic", "traditional", "trust", "unique", "unite", "upgrade",
            "useful", "value", "visual", "vote", "wealth", "wish",
            "wonder", "world", "year", "youth",
            "abandonment", "adaptable", "adventure", "affection", "alliance",
            "amusement", "anecdote", "anxiety", "apartment", "appreciate",
            "approach", "argument", "arrangement", "assembly", "attraction",
            "attractive", "audience", "automobile", "background", "behavior",
            "belonging", "beneficial", "brilliance", "challenge", "chemistry",
            "courageous", "decision", "deliberate", "dependable", "difference",
            "discovery", "distinction", "education", "environment", "essential",
            "experience", "exploration", "fascinating", "fellowship", "frequency",
            "generation", "gratitude", "inspiration", "intelligence", "introduction",
            "investigation", "leadership", "limitation", "motivation", "negotiation",
            "observation", "opportunity", "participation", "performance", "presentation",
            "preparation", "realization", "relationship", "satisfaction", "significance",
            "simulation", "technology", "understanding", "volunteering", "well-being"
    ));


    public static String generateText(int minWords, int maxWords){

        int numberOfwords = generateNumberInRange(minWords,maxWords);

        StringBuilder sentence = new StringBuilder();
        Set<Integer> selectedWords = new HashSet<>();

        for(int i = 1 ; i <= numberOfwords ; i++){
            int index;

            do{
                index = generateNumberInRange(0,300);
            }while(selectedWords.contains(index));

            selectedWords.add(index);
            sentence.append(words.get(index)).append(" ");
        }

        sentence.append(".");
        return String.valueOf(sentence).trim();
    }

    public static String generateText(int number){

        int numberOfwords = number;

        StringBuilder sentence = new StringBuilder();
        Set<Integer> selectedWords = new HashSet<>();

        for(int i = 1 ; i <= numberOfwords ; i++){
            int index;

            do{
                index = generateNumberInRange(0,300);
            }while(selectedWords.contains(index));

            selectedWords.add(index);
            sentence.append(words.get(index)).append(" ");
        }

        sentence.append(".");
        return String.valueOf(sentence).trim();
    }


    public static int generateNumberInRange(int min, int max){
        return min + (int)(Math.random()*(max+1 - min));
    }

    public static void main(String[] args) {
        System.out.println(generateText(10));
    }

}
