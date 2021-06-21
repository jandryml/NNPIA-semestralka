import GenericList from "../reusables/GenericList";
import TicketProgramListItem from "./TicketProgramListItem";
import {useParams} from "react-router";

const TicketProgramView = () => {
    const {id} = useParams();

    return (
        <GenericList title="Ticket List for Program" ListItem={TicketProgramListItem}
                     url={'http://localhost:8080/api/ticket?programId=' + id}/>
    );
};

export default TicketProgramView;
