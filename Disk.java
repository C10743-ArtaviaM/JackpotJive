public class Disk {
    String[] disk;

    public Disk(String[] disk) {
        this.disk = disk;
    }

    public String[] getResults(int result) {
        String[] visibleDisk = new String[3];

        int position = getDiskPos(result);

        if (position == 0) {
            visibleDisk[0] = this.disk[(disk.length - 1)];
            visibleDisk[1] = this.disk[position];
            visibleDisk[2] = this.disk[position + 1];
        } else if (position == disk.length - 1) {
            visibleDisk[0] = this.disk[position - 1];
            visibleDisk[1] = this.disk[position];
            visibleDisk[2] = this.disk[0];
        } else {
            visibleDisk[0] = this.disk[position - 1];
            visibleDisk[1] = this.disk[position];
            visibleDisk[2] = this.disk[position + 1];
        }

        return visibleDisk;
    }

    public int getDiskPos(int result) {
        int position;

        position = result % this.disk.length;

        return position;
    }
}
