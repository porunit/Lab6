package executionmanager;import data.comparators.StudyGroupComparator;import data.Semester;import data.StudyGroup;import exceptions.WrongDataTypeException;import java.time.format.DateTimeFormatter;import java.util.*;public class CollectionManager {    private static final HashSet<Long> uniqueId;    private static final String creationDate;    private static final String path;    private static Stack<StudyGroup> groupStack;    static {        groupStack = new Stack<>();        uniqueId = new HashSet<>();        creationDate = java.time.ZonedDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));        path = System.getenv("GOPATH");    }    public static void sort() {        groupStack.sort(new StudyGroupComparator());    }    public static void add(StudyGroup group) {        groupStack.add(group);        sort();    }    public static void remove(long id) {        StudyGroup groupForDel = null;        for (var it : groupStack) {            if (it.getId() == id) groupForDel = it;        }        groupStack.remove(groupForDel);        uniqueId.remove(id);    }    public static void clear() {        groupStack.clear();        uniqueId.clear();    }    public static void insertAt(int ind, StudyGroup group) {        groupStack.add(ind, group);        sort();    }    public static boolean checkId(long id) {        return uniqueId.contains(id);    }    public static int getAmountElements() {        return uniqueId.size();    }    public static void appendId(long id) {        uniqueId.add(id);    }    public static ArrayList<StudyGroup> getAll() {        ArrayList<StudyGroup> studyGroups = new ArrayList<>(groupStack);        return studyGroups;    }    public static List<StudyGroup> getFilteredBySemesterEnum(Semester semester) {        List<StudyGroup> groups = new ArrayList<>();        for (var it : groupStack) {            if (it.getSemester() == semester) {                groups.add(it);            }        }        return groups;    }    public static boolean isStackEmpty() {        return groupStack.isEmpty();    }    public static void load(Stack<StudyGroup> loadedStack) {        groupStack = loadedStack;    }    public static void joinId() {        ArrayList<Long> listId = new ArrayList<Long>();        for (var it : groupStack) {            if (listId.contains(it.getId())) {                throw new WrongDataTypeException();            }            listId.add(it.getId());        }        uniqueId.addAll(listId);    }    public static Class getCollectionType() {        return groupStack.getClass();    }    public static String getCreationDate() {        return creationDate;    }    public static String getFilePath() {        return path;    }    public static long getMinId() {        return Collections.min(uniqueId);    }}