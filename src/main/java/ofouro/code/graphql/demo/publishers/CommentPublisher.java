package ofouro.code.graphql.demo.publishers;

import lombok.extern.slf4j.Slf4j;
import ofouro.code.graphql.demo.model.Note;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Slf4j
@Component
public class CommentPublisher {

    Sinks.Many<NoteUpdate> sink = Sinks.many().multicast().directBestEffort();

    public CommentPublisher() {
    }

    public void publish(final Note note) {
        sink.tryEmitNext(new NoteUpdate(note.getNote(), note.getAuthor().getName(), note.getCreatedOn().toString()));
    }


    public Flux<NoteUpdate> getPublisher() {
        return sink.asFlux().map(note -> note);
    }

}
