package formatHelper;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

/************************************get the list of classes while a package name is given*************************************/
public class ClassEnumerator 
{
/*private static void log(String msg) 
{
System.out.println("ClassDiscovery: " + msg);	
}*/

private static Class<?> loadClass(String className) 
{
try
{
return Class.forName(className);
}
catch (ClassNotFoundException e) 
{
throw new RuntimeException("Unexpected ClassNotFoundException loading class '" + className + "'");
}
}

private static void processDirectory(File directory, String pkgname, ArrayList<Class<?>> classes) {
//log("Reading Directory '" + directory + "'");
// Get the list of the files contained in the package
String[] files = directory.list();

for (int i = 0; i < files.length; i++) 
{
String fileName = files[i];
String className = null;
// we are only interested in .class files
if (fileName.endsWith(".class")) 
{
// removes the .class extension
className = pkgname + '.' + fileName.substring(0, fileName.length() - 6);
}
//log("FileName '" + fileName + "' => class '" + className + "'");
if (className != null) {
classes.add(loadClass(className));
}
File subdir = new File(directory, fileName);
if (subdir.isDirectory()) {
processDirectory(subdir, pkgname + '.' + fileName, classes);
}
}
}

public static ArrayList<Class<?>> getClassesForPackage(String pkg) 
{
ArrayList<Class<?>> classes = new ArrayList<Class<?>>();

String pkgname = pkg;
String relPath = pkgname.replace('.', '/');

// Get a File object for the package
URL resource = ClassLoader.getSystemClassLoader().getResource(relPath);
if (resource == null) {
throw new RuntimeException("Unexpected problem: No resource for " + relPath);
}
//log("Package: '" + pkgname + "' becomes Resource: '" + resource.toString() + "'");
resource.getPath();
processDirectory(new File(resource.getPath()), pkgname, classes);
return classes;
}
}
