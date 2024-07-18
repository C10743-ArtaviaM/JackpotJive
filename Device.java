public class Device {
        String[] diskOne;
        String[] diskTwo;
        String[] diskThree;
        String[] diskFour;
        String[] diskFive;

        String[] diskOneResult;
        String[] diskTwoResult;
        String[] diskThreeResult;
        String[] diskFourResult;
        String[] diskFiveResult;

        Input in = new Input();

        public Device() {
                this.diskOne = new String[] { "1", "2", "3", "4", "5", "6", "A", "6", "5", "4", "3", "2", "1" };
                this.diskTwo = new String[] { "1", "3", "5", "7", "A", "B", "C", "1", "3", "5", "7", "2", "4", "6" };
                this.diskThree = new String[] { "7", "6", "5", "A", "1", "C", "B", "1", "4", "3", "A", "1", "B", "C",
                                "2",
                                "1" };
                this.diskFour = new String[] { "C", "B", "A", "C", "7", "B", "A", "1", "2", "3", "1", "2", "3", "4",
                                "5", "6",
                                "7", "7" };
                this.diskFive = new String[] { "7", "7", "6", "6", "5", "5", "4", "4", "3", "3", "2", "2", "1", "1",
                                "A", "B",
                                "B", "C", "C" };
        }

        public void generateDisk() {
                int spin = (int) (Math.random() * 248977);

                Disk firstDisk = new Disk(diskOne);
                Disk secondDisk = new Disk(diskOne);
                Disk thirdDisk = new Disk(diskOne);
                Disk fourthDisk = new Disk(diskOne);
                Disk fifthDisk = new Disk(diskOne);

                diskOneResult = firstDisk.getResults(spin);
                diskTwoResult = secondDisk.getResults(spin);
                diskThreeResult = thirdDisk.getResults(spin);
                diskFourResult = fourthDisk.getResults(spin);
                diskFiveResult = fifthDisk.getResults(spin);

                printDisk();
        }

        public void printDisk() {
                String[][] disks = new String[5][3];

                for (int j = 0; j < 3; j++) {
                        disks[0][j] = diskOneResult[j];
                        disks[1][j] = diskTwoResult[j];
                        disks[2][j] = diskThreeResult[j];
                        disks[3][j] = diskFourResult[j];
                        disks[4][j] = diskFiveResult[j];
                }

                in.printDevice(disks);
        }
}
