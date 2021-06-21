import TicketProfileListItem from "./TicketProfileListItem";
import GenericList from "../reusables/GenericList";

const TicketProfileView = ({id}) => {
    return (
        <GenericList title="Your tickets" ListItem={TicketProfileListItem}
                     url={'http://localhost:8080/api/ticket?userId=' + id}/>
    );
};

export default TicketProfileView;
