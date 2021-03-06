import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * imprime toda la lista
     */
    public void listAllFiles()
    {
        int posicion = 1;
        for(String filename : files) {
            System.out.println(posicion + "- " + filename);
            posicion++;
        }
    }

    /**
     * muestra canciones que coinciden con la cadena a buscar
     */
    public void listMaching(String textoABuscar)
    {
        boolean noHayCoincidencias=true;
        for(String filename : files) {
            if (filename.contains(textoABuscar)) {  
                System.out.println(filename);
                noHayCoincidencias = false;
            }
        }
        if (noHayCoincidencias==true){
            System.out.println("No hay coincidencias");
        }
    }

    /**
     * reproduce trozos canciones artista buscado
     */
    public void muestraArtista(String Artista){
        boolean noHayCoincidencias=true;
        for(String filename : files) {
            if (filename.contains(Artista)) {  
                player.playSample(filename);
                noHayCoincidencias = false;
            }
        }
        if (noHayCoincidencias==true){
            System.out.println("No hay coincidencias");
        }
    }

    /**
     * localiza el primer archivo que coincida y da su posicion si 
     * no devuelve -1
     */
    public int findFrist(String searchString)
    {   
        int index = 0;
        int totalFiles = files.size();
        boolean searching = true;
        while(searching && index < totalFiles){
            String filename = files.get(index);
            if(filename.contains(searchString)){
                searching = false;
            }
            else{
                index++;
            }            
        }
        if (searching = true){
            index = -1;
        }
        return index;
    }
}
