import {useEffect, useState} from "react";

import ProgramListItem from "./ProgramListItem";
import GenericList from "../reusables/GenericList";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import moment from 'moment'

const ProgramView = () => {
    const [startDate, setStartDate] = useState(new Date());
    const [url, setUrl] = useState('http://localhost:8080/api/program?date=' + moment(startDate).format("L"));

    useEffect(() => {
        setUrl('http://localhost:8080/api/program?date=' + moment(startDate).format("L"))
    }, [startDate]);

    return (
        <div>
            <DatePicker
                selected={startDate}
                dateFormat="dd/MM/yyyy"
                onChange={date => {
                    setStartDate(date);
                    console.log(moment(date).format("L"))
                }}
            />
            {startDate && <GenericList title="Program for day" ListItem={ProgramListItem}
                                       url={url}/>}
        </div>
    );
};

export default ProgramView;
