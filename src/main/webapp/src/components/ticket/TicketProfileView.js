import TicketListItem from "./TicketListItem";
import GenericList from "../reusables/GenericList";

const TicketProfileView = ({id}) => {
    return (
        <GenericList title="Your tickets" ListItem={TicketListItem}
                     url={'http://localhost:8080/api/ticket?userId=' + id}/>
    );
};

export default TicketProfileView;
