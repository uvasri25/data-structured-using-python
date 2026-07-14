class Song:
    def __init__(self, data):
        self.data = data
        self.next = None


class Playlist:
    def __init__(self):
        self.head = None

   
    def append(self, data):
        new_song = Song(data)

        if self.head is None:
            self.head = new_song
            return

        current = self.head
        while current.next:
            current = current.next

        current.next = new_song

   
    def prepend(self, data):
        new_song = Song(data)
        new_song.next = self.head
        self.head = new_song  

     
    def insert(self, position, data):
        new_song = Song(data)

        if position <= 0:
            print("Invalid Position")
            return

         
        if position == 1:
            new_song.next = self.head
            self.head = new_song
            return

        current = self.head
        count = 1

        while current is not None and count < position - 1:
            current = current.next
            count += 1

        if current is None:
            print("Invalid Position")
            return

        new_song.next = current.next
        current.next = new_song

     
    def delete(self, data):
        if self.head is None:
            print("Playlist is empty.")
            return

        if self.head.data == data:
            self.head = self.head.next
            return

        current = self.head

        while current.next:
            if current.next.data == data:
                current.next = current.next.next
                return
            current = current.next

        print("Song not found.")

     
    def display(self):
        if self.head is None:
            print("Playlist is empty.")
            return

        current = self.head

        while current:
            print(current.data, end=" -> ")
            current = current.next

        print("None")


 

playlist = Playlist()

n = int(input("Enter number of songs: "))

for i in range(n):
    song = input("Enter a song: ")
    playlist.append(song)

print("\nPlaylist:")
playlist.display()

choice = input("\nInsert song at beginning or middle (begin/middle): ").strip().lower()

if choice == "begin":
    song = input("Enter a song to insert: ")
    playlist.prepend(song)

    print("\nAfter Prepend:")
    playlist.display()

elif choice == "middle":
    position = int(input("Enter position to insert: "))
    song = input("Enter the song to insert: ")
    playlist.insert(position, song)

    print("\nAfter Insert:")
    playlist.display()

else:
    print("Invalid Choice")

song = input("\nEnter a song to delete: ")
playlist.delete(song)

print("\nAfter Delete:")
playlist.display()